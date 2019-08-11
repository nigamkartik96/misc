/*package com.aws.s3;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class FileCopyAWSImpl implements FileCopy {

	@Autowired
	Properties awsProperties;

	@Override
	public String fileCopied(String username, String productName, String filename, String image) {
		System.out.println("Inside AWS file copy");
		System.out.println("Username" + username);
		
		System.out.println("Product name : " + productName);
		System.out.println("File name : " + filename);
		System.out.println("Bucket name : " + awsProperties.getProperty("bucketName"));
		File dir = null;
		try {
			dir = new File("F:\\auction-poc-images\\" + username + "\\" + productName);
			System.out.println(dir.getAbsolutePath());
			FileOutputStream fos = null;
			if (!dir.exists()) {
				if (dir.mkdirs()) {
					fos = new FileOutputStream(
							new File("F:\\auction-poc-images\\" + username + "\\" + productName + "\\" + filename));
					fos.write(Base64.getDecoder().decode(image.split(",")[1]));
					fos.flush();
					fos.close();
				} else {
					System.out.println("Something went wrong in directory creation");
				}
			} else {
				fos = new FileOutputStream(
						new File("F:\\auction-poc-images\\" + username + "\\" + productName + "\\" + filename));
				fos.write(Base64.getDecoder().decode(image.split(",")[1]));
				fos.flush();
				fos.close();
			}

			AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new ProfileCredentialsProvider())
					.withRegion(awsProperties.getProperty("region")).build();
			try {
				client.putObject(new PutObjectRequest(awsProperties.getProperty("bucketName"), filename,
						new File("F:\\auction-poc-images\\" + username + "\\" + productName + "\\" + filename))
								.withCannedAcl(CannedAccessControlList.PublicRead));
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Done!");
			return awsProperties.getProperty("baseUrl") + "/" + username + "/" + productName + "/";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
*/