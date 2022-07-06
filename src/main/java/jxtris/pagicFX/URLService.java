package jxtris.pagicFX;

import java.net.URL;

class URLService {
    protected static URL getURL(String path) {
        StackWalker stackWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        Class<?> callerClass = stackWalker.getCallerClass();
        return callerClass.getResource(path);
    }
}
