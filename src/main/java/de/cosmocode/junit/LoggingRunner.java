package de.cosmocode.junit;

import org.junit.runner.Runner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * A {@link Runner} which logs every method invocation.
 *
 * @since 1.5
 * @author Willi Schoenborn
 */
public final class LoggingRunner extends BlockJUnit4ClassRunner {
    
    private static final Logger LOG = LoggerFactory.getLogger(LoggingRunner.class);
    
    private final String separator = Strings.repeat("=", 80);

    public LoggingRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Statement methodInvoker(FrameworkMethod method, Object test) {
        LOG.trace(separator);
        LOG.trace("Executing {}.{}()", test.getClass().getSimpleName(), method.getName());
        LOG.trace(separator);
        return super.methodInvoker(method, test);
    }
    
}
