package com.mc.qrserver.service;

import java.io.BufferedOutputStream;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRService {

	public void createQRCode(String contents, int argb, BufferedOutputStream bos) {
	
		try {
			
			QRCodeWriter qr = new QRCodeWriter();
			BitMatrix matrix = qr.encode(contents, BarcodeFormat.QR_CODE, 1000, 1000);
			MatrixToImageConfig config = new MatrixToImageConfig(argb, MatrixToImageConfig.WHITE);
			MatrixToImageWriter.writeToStream(matrix, "jpg", bos, config);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
