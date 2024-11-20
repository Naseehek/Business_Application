package com.java_Machine_Test.business_Application.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.java_Machine_Test.business_Application.entity.Product;
import com.java_Machine_Test.business_Application.entity.Sale;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class PdfGenerator {

    public static byte[] productTablePdf(List<Product> products)  {

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, out);

            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
            Paragraph title = new Paragraph("Product Table", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);

            String[] headers = {"ID", "Name", "Description", "Price", "Quantity", "Revenue"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Paragraph(header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }

            for (Product product : products) {
                table.addCell(String.valueOf(product.getId()));
                table.addCell(product.getName());
                table.addCell(product.getDescription());
                table.addCell(String.valueOf(product.getPrice()));
                table.addCell(String.valueOf(product.getQuantity()));
                double revenue = 0.0;
                for (Sale sale : product.getSales()) {
                    revenue += sale.getQuantity() * product.getPrice();
                }

                table.addCell(String.format("%.2f", revenue));

                document.add(table);
                document.close();


            }
        } catch (DocumentException e) {
            throw new RuntimeException("Error while generating pdf", e);
        }

        return out.toByteArray();

    }
}
