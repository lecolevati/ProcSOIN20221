package view;

import controller.ProcController;

public class Principal {

	public static void main(String[] args) {
		ProcController procController = new ProcController();
//		procController.prop();
//		String caminho = "regedi.exe";
//		procController.initProcess(caminho);
		
//		String processo = "TASKLIST /FO TABLE";
//		procController.readProcess(processo);
		
//		String processo = "ping www.terra.com.br";
//		procController.readProcessClean(processo);
		
		String pid = "8892";
		String opc = "notepad.exe";
		procController.killProcess(opc);
	}

}
