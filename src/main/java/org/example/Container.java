package org.example;

import java.util.Scanner;

public class Container {

  private static Scanner sc;
  public static Scanner getSc() {
      return sc;
  }

  public static void setSc(Scanner sc) {
      Container.sc = sc;
  }

  public static void init() {
    sc = new Scanner(System.in);
  }

  public static void close() {
    sc.close();
  }
}
