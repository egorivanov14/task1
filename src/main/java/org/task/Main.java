package org.task;

import org.task.entity.IntArray;
import org.task.factory.Impl.CustomIntArrayFactoryImpl;
import org.task.parser.Impl.CustomIntArrayParserImpl;
import org.task.reader.Impl.CustomFileReaderImpl;
import org.task.writer.Impl.CustomFileWriterImpl;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        CustomFileReaderImpl fileReader = new CustomFileReaderImpl();
        CustomIntArrayParserImpl arrayParser = new CustomIntArrayParserImpl();
        CustomFileWriterImpl fileWriter = new CustomFileWriterImpl();
        CustomIntArrayFactoryImpl arrayFactory = new CustomIntArrayFactoryImpl();

        List<String> line = fileReader.read();
        int[] array = arrayParser.parseToIntArray(line.getFirst());
        IntArray intArray = arrayFactory.createIntArray(array);
        System.out.println(intArray.getLength());
        fileWriter.writeToDefault(intArray.toString());
    }
}