# Selenium Testing

### Write your first user journey web ui test

Create a new test class named **TC00*_E2E_TEST-***:
- Provide Jira link in `@Link`
- List all API components in `@Feature`
- Add test severity and description
- Implement the test steps
- Use a `try/catch` block for error handling

### OpenTelemetry Tracing

To enable OpenTelemetry tracing for your Selenium tests, follow these steps:

1. Add the OpenTelemetry SDK dependencies to your `build.gradle` file:

```groovy
dependencies {
    implementation 'io.opentelemetry:opentelemetry-api:1.10.0'
    implementation 'io.opentelemetry:opentelemetry-sdk:1.10.0'
    implementation 'io.opentelemetry:opentelemetry-exporter-otlp:1.10.0'
}
```

2. Initialize the OpenTelemetry SDK in your `DriverController` class:

```java
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;

public class DriverController {
    private static OpenTelemetry openTelemetry;
    private static Tracer tracer;

    @BeforeClass
    public void setup() {
        // Initialize OpenTelemetry SDK
        OtlpGrpcSpanExporter spanExporter = OtlpGrpcSpanExporter.builder().build();
        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(spanExporter))
                .build();
        openTelemetry = OpenTelemetrySdk.builder()
                .setTracerProvider(tracerProvider)
                .buildAndRegisterGlobal();
        tracer = openTelemetry.getTracer("com.core.DriverController");

        Span span = tracer.spanBuilder("setup").startSpan();
        span.setAttribute("type", type);
        span.setAttribute("engine", engine);
        span.setAttribute("browser", browser);
        span.setAttribute("device", device);
        span.setAttribute("grid", grid);
        span.setAttribute("perf", perf);

        try {
            // Your existing setup code here
        } finally {
            span.end();
        }
    }
}
```

3. Add tracing spans for key selenium actions in your `DriverManager` class:

```java
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;

public class DriverManager extends DriverController {
    private static final OpenTelemetry openTelemetry = GlobalOpenTelemetry.get();
    private static final Tracer tracer = openTelemetry.getTracer("com.core.DriverManager");

    public void setup() {
        Span span = tracer.spanBuilder("setup").startSpan();
        try {
            // Your setup code here
        } finally {
            span.end();
        }
    }

    public void tearDown() {
        Span span = tracer.spanBuilder("tearDown").startSpan();
        try {
            // Your tearDown code here
        } finally {
            span.end();
        }
    }
}
```

By following these steps, you can enable OpenTelemetry tracing for your Selenium tests and gain insights into the performance and behavior of your tests.
