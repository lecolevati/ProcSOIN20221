package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcController {

	public ProcController() {
		super();
	}
	
	public void prop() {
		String os = System.getProperty("os.name");
		System.out.println(os);
		
		String ver = System.getProperty("os.version");
		System.out.println(ver);
		
		String arch = System.getProperty("os.arch");
		System.out.println(arch);
	}
	
	public void initProcess(String caminho) {
		try {
			Runtime.getRuntime().exec(caminho);
		} catch (Exception e) {
			String erro = e.getMessage();
			if (erro.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(caminho);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (erro.contains("2")) {
				System.err.println("Digita o caminho direito !");
			}
		}
	}
	
	
	public void readProcess(String processo) {
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			linha = buffer.readLine();
			linha = buffer.readLine();
			linha = buffer.readLine();
			
			float memoria = 0.0f;

			while (linha != null) {
//				System.out.println(linha);
				String[] vetor = linha.split(" ");
				int tamanho = vetor.length;
				String mem = vetor[tamanho - 2];

				memoria = memoria + Float.parseFloat(mem);
				
				linha = buffer.readLine();
			}
			System.out.println(memoria);
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void readProcessClean(String processo) {
		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}			
	
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void killProcess(String opc) {
		String cmdPid = "TASKKILL /PID";
		String cmdNome = "TASKKILL /IM";
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try {
			pid = Integer.parseInt(opc);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		} catch (NumberFormatException e) {
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(opc);
		}
		initProcess(buffer.toString());
	}
	
	
	
	
	
	

}
