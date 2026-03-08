package org.task;

import org.task.entity.IntArray;
import org.task.exception.IntArrayException;
import org.task.factory.Impl.CustomIntArrayFactoryImpl;
import org.task.parser.Impl.CustomIntArrayParserImpl;
import org.task.reader.Impl.CustomFileReaderImpl;
import org.task.writer.Impl.CustomFileWriterImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException, IntArrayException {

    CustomFileReaderImpl fileReader = new CustomFileReaderImpl();
    CustomIntArrayParserImpl arrayParser = new CustomIntArrayParserImpl();
    CustomFileWriterImpl fileWriter = new CustomFileWriterImpl();
    CustomIntArrayFactoryImpl arrayFactory = new CustomIntArrayFactoryImpl();

    List<String> content = fileReader.read();
    List<IntArray> intArraysList = new ArrayList<>();
    for (String line : content) {
      int[] array = arrayParser.parseToIntArray(line);
      IntArray object = arrayFactory.createIntArray(array);
      intArraysList.add(object);
    }

    for (IntArray array : intArraysList) {
      fileWriter.writeToDefault(array.toString() + " ");
    }
  }
}