package csv;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.Permission;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hlay
 * @version 1.0
 */
public class ExitDeniedSecurityManager extends SecurityManager {

  public static final class ExitSecurityException extends SecurityException {
    private final int status;

    public ExitSecurityException(final int status) {
      this.status = status;
    }

    public int getStatus() {
      return this.status;
    }
  }

  @Override
  public void checkExit(final int status) {
    super.checkExit(status);
    throw new ExitSecurityException(status);
  }

  @Override
  public void checkPermission(final Permission perm) {}

  /* TODO: Make sure you override everything with an empty method as above */
}