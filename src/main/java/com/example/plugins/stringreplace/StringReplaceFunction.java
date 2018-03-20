package com.example.plugins.stringreplace;

import org.graylog.plugins.pipelineprocessor.EvaluationContext;
import org.graylog.plugins.pipelineprocessor.ast.expressions.Expression;
import org.graylog.plugins.pipelineprocessor.ast.functions.AbstractFunction;
import org.graylog.plugins.pipelineprocessor.ast.functions.FunctionArgs;
import org.graylog.plugins.pipelineprocessor.ast.functions.FunctionDescriptor;
import org.graylog.plugins.pipelineprocessor.ast.functions.ParameterDescriptor;

public class StringReplaceFunction extends AbstractFunction<String> {
    public static final String NAME = "string_replace";
    private static final String INPUTPARAM = "input";
    private static final String TARGETPARAM = "target";
    private static final String REPLACEMENTPARAM = "replacement";

    private final ParameterDescriptor<String, String> inputParam = ParameterDescriptor
            .string(INPUTPARAM)
            .description("The input string.")
            .build();
            
    private final ParameterDescriptor<String, String> targetParam = ParameterDescriptor
            .string(TARGETPARAM)
            .description("The target string to replace.")
            .build();
            
    private final ParameterDescriptor<String, String> replacementParam = ParameterDescriptor
            .string(REPLACEMENTPARAM)
            .description("The string to replace the target with.")
            .build();

    @Override
    public String evaluate(FunctionArgs functionArgs, EvaluationContext evaluationContext) {
        final String input = inputParam.required(functionArgs, evaluationContext);
        final String target = targetParam.required(functionArgs, evaluationContext);
        final String replacement = replacementParam.required(functionArgs, evaluationContext);

        if (input == null) {
            return "";
        } else if (target == null || replacement == null) {
            return input;
        }

        return input.replace(target, replacement);
    }

    @Override
    public FunctionDescriptor<String> descriptor() {
        return FunctionDescriptor.<String>builder()
                .name(NAME)
                .description("Replaces characters in a string.")
                .params(inputParam, targetParam, replacementParam)
                .returnType(String.class)
                .build();
    }
}
