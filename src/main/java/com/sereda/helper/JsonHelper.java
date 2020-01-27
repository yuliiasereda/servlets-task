package com.sereda.helper;

import com.google.gson.Gson;
import com.sereda.dto.UpdateUserDto;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.http.HttpServletResponse;

public class JsonHelper {

  public static void sendResponse(HttpServletResponse resp, Object obj) throws IOException {
    String userJson = new Gson().toJson(obj);
    PrintWriter out = resp.getWriter();
    resp.setContentType("application/json");
    resp.setCharacterEncoding("UTF-8");
    out.print(userJson);
    out.flush();
  }

  public static String inputStreamToString(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream, "UTF-8");
    return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
  }

  public static UpdateUserDto getUserObjectFromJson(String json) {
    Gson gson = new Gson();
    return gson.fromJson(json, UpdateUserDto.class);
  }
}
