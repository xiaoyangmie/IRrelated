package de.susebox.java.io;
import java.io.IOException;
import de.susebox.java.lang.ExceptionList;
import de.susebox.java.lang.ThrowableList;
import de.susebox.java.lang.ThrowableMessageFormatter;
public class ExtIOException
  extends IOException
  implements ThrowableList, ExceptionList
{
  public Throwable nextThrowable() {
    return _next;
  }
  public Exception nextException() {
    if (_next == null) {
      return null;
    } else if (_next instanceof Exception) {
      return (Exception)_next;
    } else {
      return new RuntimeException(_next.toString());
    }
  }
  public boolean isWrapper() {
    return _isWrapper;
  }

  public boolean isWrapperException() {
    return isWrapper();
  }

  public String getFormat() {
    return super.getMessage();
  }

  public Object[] getArguments() {
    return _args;
  }

 public ExtIOException(Throwable ex) {
  this(ex, null, null);
 }

 public ExtIOException(Throwable ex, String msg) {
  this(ex, msg, null);
 }

 public ExtIOException(String fmt, Object[] args) {
   this(null, fmt, args);
 }

 public ExtIOException(Throwable ex, String fmt, Object[] args) {





   if (ex != null && fmt == null) {
     _isWrapper = true;
   } else {
     _isWrapper = false;
   }
   _next = ex;
   _args = args;
 }

 public String getMessage() {



   return ThrowableMessageFormatter.getMessage(this);

 }

        protected Object[] _args = null;

  protected Throwable _next = null;

  protected boolean _isWrapper = false;
}
