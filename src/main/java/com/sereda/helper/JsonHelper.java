package com.sereda.helper;

import static com.sereda.utils.EndpointConstants.JSON_CONTENT_TYPE;
import static com.sereda.utils.EndpointConstants.UTF8;

import com.google.gson.Gson;
import com.sereda.dto.UpdateUserDto;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.http.HttpServletResponse;

public class JsonHelper {

  private final static Gson gson = new Gson();

  public static void sendResponse(HttpServletResponse resp, Object obj) throws IOException {
    String userJson = gson.toJson(obj);
    PrintWriter out = resp.getWriter();
    resp.setContentType(JSON_CONTENT_TYPE);
    resp.setCharacterEncoding(UTF8);
    out.print(userJson);
    out.flush();
  }

  private static String inputStreamToString(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream, UTF8);
    return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
  }

  private static UpdateUserDto getUserObjectFromJson(String json) {
    return gson.fromJson(json, UpdateUserDto.class);
  }

  public static UpdateUserDto getUserObjectFromInputStream(InputStream inputStream) {
    return getUserObjectFromJson(inputStreamToString(inputStream));
  }
}
