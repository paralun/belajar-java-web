/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.belajar.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WhitespaceFilter implements Filter {
    
    private static final String[] START_TRIM_AFTER = {"<html", "</textarea", "</pre"};
    private static final String[] STOP_TRIM_AFTER = {"</html", "<textarea", "<pre"};

    public WhitespaceFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (response instanceof HttpServletResponse) {
            HttpServletResponse httpres = (HttpServletResponse) response;
            chain.doFilter(request, wrapResponse(httpres, createTrimWriter(httpres)));
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    private static PrintWriter createTrimWriter(final HttpServletResponse response)
            throws IOException {
        return new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF-8"), true) {
            private StringBuilder builder = new StringBuilder();
            private boolean trim = false;

            @Override
            public void write(int c) {
                builder.append((char) c); // It is actually a char, not an int.
            }

            @Override
            public void write(char[] chars, int offset, int length) {
                builder.append(chars, offset, length);
                this.flush(); // Preflush it.
            }

            @Override
            public void write(String string, int offset, int length) {
                builder.append(string, offset, length);
                this.flush(); // Preflush it.
            }

            // Finally override the flush method so that it trims whitespace.
            @Override
            public void flush() {
                synchronized (builder) {
                    BufferedReader reader = new BufferedReader(new StringReader(builder.toString()));
                    String line = null;

                    try {
                        while ((line = reader.readLine()) != null) {
                            if (startTrim(line)) {
                                trim = true;
                                out.write(line);
                            } else if (trim) {
                                out.write(line.trim());
                                if (stopTrim(line)) {
                                    trim = false;
                                    println();
                                }
                            } else {
                                out.write(line);
                                println();
                            }
                        }
                    } catch (IOException e) {
                        setError();
                        // Log e or do e.printStackTrace() if necessary.
                    }

                    // Reset the local StringBuilder and issue real flush.
                    builder = new StringBuilder();
                    super.flush();
                }
            }

            private boolean startTrim(String line) {
                for (String match : START_TRIM_AFTER) {
                    if (line.contains(match)) {
                        return true;
                    }
                }
                return false;
            }

            private boolean stopTrim(String line) {
                for (String match : STOP_TRIM_AFTER) {
                    if (line.contains(match)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    private static HttpServletResponse wrapResponse(
            final HttpServletResponse response, final PrintWriter writer) {
        return new HttpServletResponseWrapper(response) {
            @Override
            public PrintWriter getWriter() throws IOException {
                return writer;
            }
        };
    }
}
