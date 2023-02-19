package com.API.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {

	public static Properties a;

	public static Properties fileconfig() throws IOException {

		String projectPath = System.getProperty("user.dir");
		FileReader reader = new FileReader(projectPath + "/src/main/resources/config/config.properties");
		Properties props = new Properties();
		props.load(reader);

		return a = props;

	}

	public static String setCreteAPI_baseURI() throws IOException {

		fileconfig();
		String createAPIBaseURI = a.getProperty("CreateAPI_baseURI");
		return createAPIBaseURI;

	}

	public static String setCreteAPI_basePath() throws IOException {

		fileconfig();
		String createAPIBasePath = a.getProperty("CreateAPI_basePath");
		return createAPIBasePath;

	}

	public static String setUserList_baseURI() throws IOException {

		fileconfig();
		String userListBaseURL = a.getProperty("UserList_baseURI");
		return userListBaseURL;

	}

	public static String setUserList_basePath() throws IOException {

		fileconfig();
		String userListBasePath = a.getProperty("UserList_basePath");
		return userListBasePath;

	}

	public static String setMenu_baseURI() throws IOException {

		fileconfig();
		String menuBaseURI = a.getProperty("Menu_baseURI");
		return menuBaseURI;

	}

	public static String setMenu_basePath() throws IOException {

		fileconfig();
		String menuBasePath = a.getProperty("Menu_basePath");
		return menuBasePath;

	}

	public static String setCommentPost_baseURI() throws IOException {

		fileconfig();
		String commentBaseURI = a.getProperty("CommentsPost_baseURI");
		return commentBaseURI;

	}

	public static String setCommnetPost_basePath() throws IOException {

		fileconfig();
		String commentBasePath = a.getProperty("CommentsPost_basePath");
		return commentBasePath;

	}

	public static String setCommentPost_query() throws IOException {

		fileconfig();
		String commentQuery = a.getProperty("CommentsPost_query");
		return commentQuery;
	}

}
