package com.irusist.commons.cli;

import org.apache.commons.cli.*;

/**
 *   HelpFormatter helpFormatter = new HelpFormatter();
 *   helpFormatter.setWidth(80);
 *   helpFormatter.printHelp(USAGE, HEADER, options, FOOTER);
 *   打印顺序为：
 *   usage: USAGE
 *   HEADER
 *    -option,--optionLong <argName>  description
 *   FOOTER
 *
 * @author zhulixin
 */
public class PrintUsageInformation {

    private static final String USAGE = "[-h] [-v] [-f <file> | -m <email>]";

    private static final String HEADER = "PrintUsageInformation -A fancy and" +
            "expensive program, Copyright 2010 Blah.";

    private static final String FOOTER = "For more instructions, see our " +
            "website at http://www.blash123.org";

    public static void main(String[] args) {
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE information");

        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(OptionBuilder.hasArg(true).withArgName("file")
                .withLongOpt("file").create('f'));
        optionGroup.addOption(OptionBuilder.hasArg(true).withArgName("email")
        .withLongOpt("email").create('m'));

        options.addOptionGroup(optionGroup);

        // 如果指定参数错误，输出以下信息
//        You provided bad pogram arguments!
//        usage: [-h] [-v] [-f <file> | -m <email>]
//        PrintUsageInformation -A fancy andexpensive program, Copyright 2010 Blah.
//         -f,--file <file>
//         -h,--help            Print this usage information
//         -m,--email <email>
//         -v,--verbose         Print out VERBOSE information
//        For more instructions, see our website at http://www.blash123.org
        try {
            CommandLine commandLine = parser.parse(options, args);

            if(commandLine.hasOption('h')) {
                printUsage(options);
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("You provided bad pogram arguments!");
            printUsage(options);
            System.exit(1);
        }
    }

    private static void printUsage(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.setWidth(80);
        helpFormatter.printHelp(USAGE, HEADER, options, FOOTER);
    }
}
