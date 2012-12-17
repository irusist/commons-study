package com.irusist.commons.cli;

import org.apache.commons.cli.*;

/**
 *  OptionGroup optionGroup = new OptionGroup();
 *  optionGroup.addOption(OptionBuilder.hasArg(true).create('f'));
 *  optionGroup.addOption(OptionBuilder.hasArg(true).create('m'));
 *  options.addOptionGroup(optionGroup);
 *  OptionGroup用来选择几者之中的一个，如果同时指定会抛出AlreadySelectedException，
 *  在这里只能指定-m和-f之中的一个，如果都指定，则会抛出AlreadySelectedException
 *  OptionBuilder.hasArg(true).isRequired(true).create('f')用来生成Option
 *
 * @author zhulixin
 */
public class ParseComplexCommandLine {

    public static void main(String[] args) {
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("h", "help", false, "Print this usage information");
        options.addOption("v", "verbose", false, "Print out VERBOSE information");

        OptionGroup optionGroup = new OptionGroup();
        optionGroup.addOption(OptionBuilder.hasArg(true).create('f'));
        optionGroup.addOption(OptionBuilder.hasArg(true).create('m'));
        options.addOptionGroup(optionGroup);

        try {
            CommandLine commandLine = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
