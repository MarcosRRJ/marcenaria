package br.com.umc.marcenaria.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.umc.marcenaria.dao.ImagemDao;
import br.com.umc.marcenaria.dao.impl.ImagemDaoImpl;

//@WebServlet(urlPatterns = "/upload")
public class UploadArquivoServlet extends HttpServlet {

	private File diretorio;
	ImagemDao dao = new ImagemDaoImpl();
	String valorDoCampo;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String path = config.getInitParameter("diretorio");
		diretorio = new File(path);
		diretorio.mkdirs();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			out.println("<h1>Voce não enviou um arquivo!</h1>");
			return;
		}

		for (String elemento : request.getParameterMap().keySet()) {
			System.out.println(elemento);
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(diretorio);

		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					processUploadedFile(item, request);
					String caminhaDaImg = diretorio.getPath() + "/" + (new File(item.getName()).getName());
					dao.cadastrarDocumento(caminhaDaImg, Integer.parseInt(valorDoCampo));
				} else {
					// para inputs que nao sao 'file', isFormField() é
					valorDoCampo = item.getString();
				}
			}

			out.println("<h1>Arquivo gravado!</h1>");

		} catch (Exception e) {
			out.println("<h1>Erro ao escrever no arquivo!</h1>");
			return;
		}

	}

	private void processUploadedFile(FileItem item, HttpServletRequest request) throws Exception {
		try {

			// Obtenha o arquivo e construa o caminho do arquivo local
			String filename = (new File(item.getName()).getName());
			String realPath = request.getServletContext().getRealPath("/" + diretorio);
			String filepath = Paths.get(realPath, filename).toString();

			// Salve o arquivo localmente no Servidor
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(item.get());
			stream.close();

		} catch (Exception e) {

		}
	}

}