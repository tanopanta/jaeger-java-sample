/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jaeger.java.sample;


import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

public class App {
    private final Tracer tracer;
    
    public App (OpenTelemetry openTelemetry) {
        this.tracer = openTelemetry.getTracer("jaeger.java.sample", "v1.0.0");
    }

    public String getGreeting() {
        Span span = this.tracer.spanBuilder("getGreeting").startSpan();

        span.addEvent("test");
        span.end();
        return "Hello World!";
    }

    public static void main(String[] args) {
        OpenTelemetry openTelemetry = JaegerConfiguration.initOpenTelemetry("http://localhost:4317");

        System.out.println(new App(openTelemetry).getGreeting());
    }
}
