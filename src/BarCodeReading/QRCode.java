package BarCodeReading;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;

import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {
	private static Webcam webcam;
	private static String decodeQRCode(File qrCodeimage) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
        LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        try {
            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (NotFoundException e) {
            System.out.println("There is no QR code in the image");
            return null;
        }
    }
	
	public static void init() {
		webcam = Webcam.getDefault();
		webcam.open();
	}
	
	public static boolean hasSpecificQRCode(String code) {
	
    	Result result = null;
    	
    	BufferedImage image = null;
    	
    	if (webcam.isOpen()) {
    	    if ((image = webcam.getImage()) == null) {
    	        return false;
    	    }

    	    LuminanceSource source = new BufferedImageLuminanceSource(image);
    	    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
    	    try {
    	        result = new MultiFormatReader().decode(bitmap);
    	    } catch (NotFoundException e) {
    	    	return false;
    	    }
    	}

    	if (result != null) {
    	   return (result.getText().equals(code)) ;
    	}
    	return false;
    	
	}

    public static void main(String[] args) {
    	System.out.println(Webcam.getWebcams().size());
    	System.out.println(Webcam.getWebcams().toString());
    
    	int numResults = 0;
    	ArrayList<String> results = new ArrayList<String>();
    	Result result = null;
    	
    	BufferedImage image = null;
    	while (numResults < 10) {
    	if (webcam.isOpen()) {
    	    if ((image = webcam.getImage()) == null) {
    	        continue;
    	    }

    	    LuminanceSource source = new BufferedImageLuminanceSource(image);
    	    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
    	    try {
    	        result = new MultiFormatReader().decode(bitmap);
    	        if (results.size() > 0 && !results.contains(result.getText())) {
    	        	 results.add(result.getText());
    	        }
    	        else if (results.size() == 0) {
    	        	results.add(result.getText());
    	        }
    	       
    	    } catch (NotFoundException e) {
    	    	result = null;
    	        // fall thru, it means there is no QR code in image
    	    }
    	}

    	if (result != null) {
    	    for (int i = 0; i < results.size(); i ++) {
    	    	System.out.print(results.get(i) + ",");
    	    }
    	    System.out.println("");
    	}
    }
    	
    }
}