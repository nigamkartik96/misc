package com.aws.s3;

import java.io.File;
import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class S3Demo {

	public static void main(String[] args) {
		S3Demo demo = new S3Demo();

		// demo.createBucket("auction-poc-demo", "us-east-2");
		// demo.createBucket("demo-bucket-kartik", "us-east-2");
		// demo.listBucketNames();
		// "C:\\Users\\Kartik\\Desktop\\login.properties";

		demo.storeAnObjectToAWS("kartik/Zookeeper Installion Guide.docx", "auction-poc-demo",
				new File("C:\\Users\\Kartik\\Desktop\\Setup guides\\Zookeeper Installion Guide.docx"));
		// demo.getListOfObject("auction-poc-demo");
	}

	public void createBucket(String bucketName, String regionName) {
		try {
			AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new ProfileCredentialsProvider())
					.withRegion(regionName).build();
			System.out.println("Line 21 : Bucket Exist: " + client.doesBucketExistV2(bucketName));
			if (!client.doesBucketExistV2(bucketName)) {
				Bucket bucket = client.createBucket(bucketName);
				System.out.println("Bucket Location : " + bucket.getOwner());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listBucketNames() {
		AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new ProfileCredentialsProvider())
				.withRegion("us-east-2").build();
		List<Bucket> buckets = client.listBuckets();
		for (Bucket bucket : buckets) {
			/*
			 * com.amazonaws.services.s3.model.Owner owner = new
			 * com.amazonaws.services.s3.model.Owner(); owner.setDisplayName("Kartik");
			 * owner.setId(
			 * "09d5ac6f581528b299f362f6c6f7eb635aeaa85e646eac3f3ff754ca6f70313f");
			 * bucket.setOwner(owner);
			 */
			System.out.println(bucket.getName());
		}
	}

	public void storeAnObjectToAWS(String keyName, String bucketName, File file) {
		AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new ProfileCredentialsProvider())
				.withRegion("us-east-2").build();
		try {
			// client.putObject(bucketName, keyName, file);
			
			PutObjectResult result = client.putObject(
					new PutObjectRequest(bucketName, keyName, file).withCannedAcl(CannedAccessControlList.PublicRead));
			//System.out.println(result.getMetadata().get);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done!");
	}

	public void getListOfObject(String bucketName) {
		AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new ProfileCredentialsProvider())
				.withRegion("us-east-2").build();
		
		try {
			// System.out.println(client.listObjectsV2(bucketName));
			ListObjectsV2Result result = client.listObjectsV2(bucketName);
			List<S3ObjectSummary> objectSummaries = result.getObjectSummaries();
			for (S3ObjectSummary os : objectSummaries) {
				System.out.println(os.getKey());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
