package com.dbs.sg.DTE12.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dbs.sg.DTE12.common.AESManager;
import com.dbs.sg.DTE12.common.LoadConfigXml;
import com.dbs.sg.DTE12.common.Logger;

public class sqlplus {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("1");
			System.exit(1);
		}
		boolean bPrintOutput = false;
		String[] newargs;
		List tmp = Arrays.asList(args);
		List lstArgs = new ArrayList();
		lstArgs.addAll(tmp);
		if (lstArgs.contains("-OY")){
			bPrintOutput = true;
			newargs = new String[args.length-1];
			lstArgs.remove("-OY");
			newargs = (String[]) lstArgs.toArray(new String[]{});
		}
		else
			newargs = args;

		String configPath = newargs[0];

		Logger logger = Logger.getLogger(configPath, sqlplus.class);

		LoadConfigXml configXml = LoadConfigXml.getConfig(configPath);
		AESManager aes = new AESManager(configPath);
		String pwd = aes.Descrypt(configXml.getKeyFile(), configXml
				.getEncryptFile());

		boolean readFromConsoleFlg = false;

		try {
			logger.info("Start to run sqlplus with parameters:"
					+ Arrays.asList(args));

			List plist = new ArrayList();
			plist.add("sqlplus");
			for (int j = 1; j < newargs.length; j++) {
				if (newargs[j].startsWith("-"))
					plist.add(newargs[j]);
				if (newargs[j].indexOf("@") >= 0)
					readFromConsoleFlg = true;
			}
			plist.add(configXml.getUserid() + "@" + configXml.getDBName());
			for (int j = 1; j < newargs.length; j++) {
				if (!newargs[j].startsWith("-"))
					plist.add(newargs[j]);
			}

			String[] params = new String[plist.size()];
			for (int i = 0; i < plist.size(); i++) {
				params[i] = (String) plist.get(i);
			}

			Process proc = Runtime.getRuntime().exec(params,null);

			PrintWriter pr = new PrintWriter(proc.getOutputStream(), true);

			pr.println(pwd);
			Thread.sleep(100);

			if (!readFromConsoleFlg) {
				logger.info("begin read from console...");
				BufferedReader in = new BufferedReader(new InputStreamReader(
						System.in));
				String cmdIn;
				while ((cmdIn = in.readLine()) != null) {
					logger.info(cmdIn);
					if (!"end".equalsIgnoreCase(cmdIn.trim()))
						pr.println(cmdIn);
				}
				logger.info("read from console ok.");
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(proc
					.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null){
				if (bPrintOutput)
					System.out.println(line);
				logger.info("sqlplus>" + line);
			}

			int result = proc.waitFor();
			result = proc.exitValue();
			logger.info("sqlplus>result:" + result);
			if (result != 0) {
				logger.error("Run sqlplus failed with return code[" + result
						+ "].");
				System.out.println(result);
				System.exit(result);
			}

			logger.info("Run sqlplus completely with parameters:"
					+ Arrays.asList(args));
			System.exit(result);
		} catch (Exception e) {
			logger.error("Run sqlplus failed.", e);
			System.out.println("1");
			System.exit(1);
		}

	}

}
