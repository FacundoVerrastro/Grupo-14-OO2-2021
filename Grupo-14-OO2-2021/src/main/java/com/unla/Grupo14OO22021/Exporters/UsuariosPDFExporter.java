package com.unla.Grupo14OO22021.Exporters;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.Grupo14OO22021.entities.Usuario;

public class UsuariosPDFExporter {
	private List<Usuario> lstUsario;
    
    public UsuariosPDFExporter(List<Usuario> lstUsario) {
        this.lstUsario = lstUsario;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Nombre", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Apellido", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Tipo Documento", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Numero Documento", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("NomUsuario", font));
        table.addCell(cell);    
        
        cell.setPhrase(new Phrase("Password", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Tipo de Perfil", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
        for (Usuario usuario : lstUsario) {
            table.addCell(String.valueOf(usuario.getNombre()));
            table.addCell(usuario.getApellido());
            table.addCell(usuario.getTipoDocumento());
            table.addCell(String.valueOf(usuario.getNumeroDocumento()));
            table.addCell(usuario.getEmail());
            table.addCell(usuario.getNomUsuario());
            table.addCell(usuario.getPassword());
            table.addCell(usuario.getPerfil().getTipo());
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Lista de Usuarios", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.8f, 2.5f, 2.0f, 2.5f, 3.0f, 2.5f, 2.5f, 3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
