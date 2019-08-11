package com.solr.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.solr.model.NCRSolrModel;

public class SolrMain {
	public static void main(String[] args) {
		SolrMain solrMain = new SolrMain();
		/*ArrayList<NCRSolrModel> documents = solrMain.getNCRDataFromXML();
		// System.out.println(documents);

		if (solrMain.indexToSolr(documents)) {
			System.out.println("Indexed!");
		} else {
			System.out.println("Not indexed");
		}*/
		
		solrMain.stringUse();

		
	}
	
	public void stringUse( ) {
		String s = "aaaa";
		System.out.println(Stream.of(s)
        .map(String::chars)
        .flatMap(intStream -> intStream.mapToObj(charCode -> (char) charCode))
        .distinct()
        .sorted()
        .map(character -> new String(new char[]{character}))
        .collect(Collectors.toList()));
	}

	public ArrayList<NCRSolrModel> getNCRDataFromXML() {
		ArrayList<NCRSolrModel> docs = new ArrayList<>();
		File file = new File("C:\\Users\\Kartik\\Desktop\\select.xml");
		String id, title, url = null, metaDescription, tstamp, lastModified, content, product;
		ArrayList<String> type = new ArrayList<>();
		try {
			Document document = Jsoup.parse(file, "UTF-8");
			List<Element> elements = document.select("doc");
			System.out.println(elements.size());
			for (Element element : elements) {
				id = "";
				title = "";
				url = "";
				metaDescription = "";
				tstamp = "";
				lastModified = "";
				content = "";
				product = "";
				type = new ArrayList<>();
				if (element.selectFirst("str[name='id']") != null) {
					id = element.selectFirst("str[name='id']").text();
				}
				if (element.selectFirst("str[name='title']") != null) {
					title = element.selectFirst("str[name='title']").text();
				}
				if (element.selectFirst("str[name='url']") != null) {
					url = element.selectFirst("str[name='url']").text();
				}
				if (element.selectFirst("str[name='meta_description']") != null) {
					metaDescription = element.selectFirst("str[name='meta_description']").text();
				}
				if (element.selectFirst("str[name='id']") != null) {
					tstamp = element.selectFirst("date[name='tstamp']").text();
				}
				if (element.selectFirst("date[name='lastModified']") != null) {
					lastModified = element.selectFirst("date[name='lastModified']").text();
				}
				if (element.selectFirst("str[name='content']") != null) {
					content = element.selectFirst("str[name='content']").text();
				}
				product = getProduct(url);

				if (element.selectFirst("arr[name='type']") != null) {
					type = getTypes(element.selectFirst("arr[name='type']").select("str"));
				}
				docs.add(new NCRSolrModel(id, title, type, url, metaDescription, tstamp, lastModified, content,
						product));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return docs;
	}

	// https://www.ncr.com/careers/work-at-ncr/early-careers
	public String getProduct(String url) {
		String product = "ncr";
		String[] urls = url.split("/");
		if (urls.length >= 4) {
			product = urls[3];
		}
		return product;
	}

	public ArrayList<String> getTypes(List<Element> elements) {
		ArrayList<String> types = new ArrayList<>();
		for (Element element : elements) {
			if (element != null) {
				if (element.hasText()) {
					types.add(element.text());
				}
			}
		}
		return types;
	}

	public boolean indexToSolr(ArrayList<NCRSolrModel> documents) {
		String solrURL = "http://localhost:8983/solr/ncrCore/";
		SolrClient client = null;
		try {
			client = new HttpSolrClient.Builder(solrURL).build();
			SolrInputDocument document = null;
			for (NCRSolrModel doc : documents) {

				document = new SolrInputDocument();
				document.addField("id", doc.getId());
				document.addField("title", doc.getTitle());
				document.addField("type", doc.getType());
				document.addField("url", doc.getUrl());
				document.addField("meta-description", doc.getMetaDescription());
				document.addField("tstamp", doc.getTstamp());
				document.addField("lastModified", doc.getLastModified());
				document.addField("content", doc.getContent());
				document.addField("product", doc.getProduct());

				client.add(document);
			}
			client.commit();
			client.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/* 
	 
	 for(int i = 2; i <= n; i ++) {
            for (int j = 0; j <= n - i; j ++) {
                //System.out.print(s.substring(j, j+i) + " ");
                s1 = new StringBuilder(builder.substring(j, j+i));
                mid = s1.length() / 2;
                if(s1.length() %2 != 0) {       
                    s2 = new StringBuilder(s1.substring(0, mid));
                    s3 = new StringBuilder(s1.substring(mid+1)).reverse();
                    System.out.print("1 : " + s2 + " 2 : " + s3 + " \n");
                    List<String> s2c = Stream.of(s2.toString() + s3.toString())
        .map(String::chars)
        .flatMap(intStream -> intStream.mapToObj(charCode -> (char) charCode))
        .distinct()
        .sorted()
        .map(character -> new String(new char[]{character}))
        .collect(Collectors.toList());
        //             List<String> s3c = Stream.of(s3.toString())
        // .map(String::chars)
        // .flatMap(intStream -> intStream.mapToObj(charCode -> (char) charCode))
        // .distinct()
        // .sorted()
        // .map(character -> new String(new char[]{character}))
        // .collect(Collectors.toList());
                    if (s2c.size() == 1) {
                        
                    
                   // if(s3.toString().equals(s2.toString())) {
                        count ++;
                    //} 
                }
                }
                else{
                    s2 = new StringBuilder(s1.substring(0, mid));
                    s3 = new StringBuilder(s1.substring(mid)).reverse();
                    System.out.print("1 : " + s2 + " 2 : " + s3 + " \n");     
                    List<String> s2c = Stream.of(s2.toString()+s3.toString()).map(String::chars)
        .flatMap(intStream -> intStream.mapToObj(charCode -> (char) charCode)).distinct()
        .sorted().map(character -> new String(new char[]{character}))
        .collect(Collectors.toList());
        //             List<String> s3c = Stream.of(s3.toString())
        // .map(String::chars)
        // .flatMap(intStream -> intStream.mapToObj(charCode -> (char) charCode))
        // .distinct()
        // .sorted()
        // .map(character -> new String(new char[]{character}))
        // .collect(Collectors.toList());
                    //System.out.print("1 : " + s2c.size() + " 2 : " + s3c.size() + " \n");     
                    if (s2c.size() == 1) {
                        
                    
                    //if(s3.toString().equals(s2.toString())) {
                        count ++;
                   // } 
                }
                }
             //   System.out.print(" " + s1.substring(0, j) + " " + s1.substring(s1.length() - j));
                
            }
            System.out.println();
        }
	 
	 */
	 
}
