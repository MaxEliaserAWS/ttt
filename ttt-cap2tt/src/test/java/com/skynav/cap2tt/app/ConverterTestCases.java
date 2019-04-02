/*
 * Copyright 2015 Skynav, Inc. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY SKYNAV, INC. AND ITS CONTRIBUTORS “AS IS” AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL SKYNAV, INC. OR ITS CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 
package com.skynav.cap2tt.app;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.w3c.dom.Document;

import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;

import com.skynav.ttv.util.TextReporter;
import com.skynav.ttv.util.Reporter;

public class ConverterTestCases {

    @Test
    public void testConversion001Mixed() throws Exception {
        performConversionTest("test-001-mixed.cap", 0, 0);
    }

    @Test
    public void testConversion002Mixed() throws Exception {
        performConversionTest("test-002-mixed.cap", 0, 0);
    }

    @Test
    public void testConversion003ScreenAttrItalics() throws Exception {
        performConversionTest("test-003-screen-attr-italics.cap", 0, 0);
    }

    @Test
    public void testConversion004SpaceBeforeNonTextAttribute() throws Exception {
        performConversionTest("test-004-space-before-non-text-attribute.cap", 0, 1);
    }

    @Test
    public void testConversion005PlacementAndAlignmentContinuation() throws Exception {
        performConversionTest("test-005-placement-and-alignment-continuation.cap", 0, 0);
    }

    @Test
    public void testConversion006RegionPositionInitialValue() throws Exception {
        performConversionTest("test-006-region-position-initial-value.cap", 0, 0);
    }

    @Test
    public void testConversion007TateChuYoko() throws Exception {
        performConversionTest("test-007-tate-chu-yoko.cap", 0, 0);
    }

    @Test
    public void testConversion008EscapedHalfWidthSpace() throws Exception {
        performConversionTest("test-008-escaped-half-width-space.cap", 0, 0);
    }

    @Test
    public void testConversion009EscapedFullWidthSpace() throws Exception {
        performConversionTest("test-009-escaped-full-width-space.cap", 0, 0);
    }

    @Test
    public void testConversion010PlacementContinuation() throws Exception {
        performConversionTest("test-010-placement-continuation.cap", 0, 0);
    }

    @Test
    public void testConversion011PlacementAndAlignmentContinuation() throws Exception {
        performConversionTest("test-011-placement-and-alignment-continuation.cap", 0, 0);
    }

    @Test
    public void testConversion012PlacementAndAlignmentRetained() throws Exception {
        performConversionTest("test-012-placement-and-alignment-retained.cap", 0, 0);
    }

    @Test
    public void testConversion013PlacementAndAlignmentDefault() throws Exception {
        performConversionTest("test-013-placement-and-alignment-default.cap", 0, 0);
    }

    @Test
    public void testConversion014SniffUTF8NoBOM() throws Exception {
        performConversionTest("test-014-sniff-utf8-no-bom.cap", 0, 0);
    }

    @Test
    public void testConversion015RubyPosition() throws Exception {
        performConversionTest("test-015-ruby-position.cap", 0, 0);
    }

    @Test
    public void testConversion016EmphasisPosition() throws Exception {
        performConversionTest("test-016-emphasis-position.cap", 0, 0);
    }

    @Test
    public void testConversion017EmphasisMixed() throws Exception {
        performConversionTest("test-017-emphasis-mixed.cap", 0, 0);
    }

    @Test
    public void testConversion018NestedDesignations1() throws Exception {
        performConversionTest("test-018-nested-designations-1.cap", 0, 0);
    }

    @Test
    public void testConversion019SpaceInAnnotationEmphasis() throws Exception {
        performConversionTest("test-019-space-in-annotation-emphasis.cap", 0, 0);
    }

    @Test
    public void testConversion020SpaceInAnnotationIssue113() throws Exception {
        performConversionTest("test-020-space-in-annotation-issue-113.cap", 0, 0);
    }

    @Test
    public void testConversion021SpaceInAnnotationIssue112() throws Exception {
        performConversionTest("test-021-space-in-annotation-issue-112.cap", 0, 0);
    }

    @Test
    public void testConversion022MultipleSpacesIssue110() throws Exception {
        performConversionTest("test-022-multiple-spaces-issue-110.cap", 0, 0);
    }

    @Test
    public void testConversion023SpaceInAnnotationIssue133Case1() throws Exception {
        performConversionTest("test-023-space-in-annotation-issue-133-case-1.cap", 0, 0);
    }

    @Test
    public void testConversion024SpaceInAnnotationIssue133Case2() throws Exception {
        performConversionTest("test-024-space-in-annotation-issue-133-case-2.cap", 0, 0);
    }

    @Test
    public void testConversion025FalseScreenNumberIssue138Case1() throws Exception {
        performConversionTest("test-025-false-screen-number-issue-138-case-1.cap", 0, 0);
    }

    @Test
    public void testConversion026FalseScreenNumberIssue138Case2() throws Exception {
        performConversionTest("test-026-false-screen-number-issue-138-case-2.cap", 0, 0);
    }

    @Test
    public void testConversion027FalseScreenNumberIssue138Case3() throws Exception {
        performConversionTest("test-027-false-screen-number-issue-138-case-3.cap", 0, 0);
    }

    @Test
    public void testConversion028FalseAttributePrefixIssue145() throws Exception {
        performConversionTest("test-028-false-attribute-prefix-issue-145.cap", 0, 0);
    }

    @Test
    public void testConversion029NestedDesignations2() throws Exception {
        performConversionTest("test-029-nested-designations-2.cap", 0, 0);
    }

    private void performConversionTest(String resourceName, int expectedErrors, int expectedWarnings) {
        performConversionTest(resourceName, expectedErrors, expectedWarnings, null);
    }

    private void performConversionTest(String resourceName, int expectedErrors, int expectedWarnings, String[] additionalOptions) {
        URL url = getClass().getResource(resourceName);
        if (url == null)
            fail("Can't find test resource: " + resourceName + ".");
        String urlString = url.toString();
        URI uri;
        try {
            uri = new URI(urlString);
        } catch (URISyntaxException e) {
            fail("Bad test resource syntax: " + urlString + ".");
            return;
        }
        List<String> args = new java.util.ArrayList<String>();
        args.add("-v");
        args.add("-v");
        args.add("--warn-on");
        args.add("all");
        if (expectedErrors >= 0) {
            args.add("--expect-errors");
            args.add(Integer.toString(expectedErrors));
        }
        if (expectedWarnings >= 0) {
            args.add("--expect-warnings");
            args.add(Integer.toString(expectedWarnings));
        }
        args.add("--output-disable");
        args.add("--retain-document");
        maybeAddConfiguration(args, uri);
        if (additionalOptions != null) {
            args.addAll(java.util.Arrays.asList(additionalOptions));
        }
        args.add(urlString);
        Converter cvt = new Converter();
        Reporter reporter = new TextReporter();
        Document d = cvt.convert(args, uri, reporter, (Document) null);
        Converter.Results r = cvt.getResults(urlString);
        assertEquals(d, r.getDocument());
        maybeCheckDifferences(d, uri);
        int resultCode = r.getCode();
        int resultFlags = r.getFlags();
        if (resultCode == Converter.RV_SUCCESS) {
            if ((resultFlags & Converter.RV_FLAG_ERROR_EXPECTED_MATCH) != 0) {
                fail("Unexpected success with expected error(s) match.");
            }
            if ((resultFlags & Converter.RV_FLAG_WARNING_UNEXPECTED) != 0) {
                fail("Unexpected success with unexpected warning(s).");
            }
            if ((resultFlags & Converter.RV_FLAG_WARNING_EXPECTED_MISMATCH) != 0) {
                fail("Unexpected success with expected warning(s) mismatch.");
            }
        } else if (resultCode == Converter.RV_FAIL) {
            if ((resultFlags & Converter.RV_FLAG_ERROR_UNEXPECTED) != 0) {
                fail("Unexpected failure with unexpected error(s).");
            }
            if ((resultFlags & Converter.RV_FLAG_ERROR_EXPECTED_MISMATCH) != 0) {
                fail("Unexpected failure with expected error(s) mismatch.");
            }
        } else
            fail("Unexpected result code " + resultCode + ".");
    }

    private void maybeAddConfiguration(List<String> args, URI u) {
        String[] components = getComponents(u);
        if (hasFileScheme(components)) {
            File f = getConfiguration(components);
            if (f != null) {
                try {
                    String p = f.getCanonicalPath();
                    args.add("--config");
                    args.add(p);
                } catch (IOException e) {
                }
            }
        }
    }

    private File getConfiguration(String[] components) {
        File f1 = new File(joinComponents(components, ".config.xml"));
        if (f1.exists())
            return f1;
        File f2 = new File(joinComponents(components, "test", ".config.xml"));
        if (f2.exists())
            return f2;
        return null;
    }

    private void maybeCheckDifferences(Document d, URI u) {
        String[] components = getComponents(u);
        if (hasFileScheme(components)) {
            File f = new File(joinComponents(components, ".expected.xml"));
            if (f.exists()) {
                checkDifferences(d, f);
            }
        }
    }

    private void checkDifferences(Document d, File f) {
        Diff diff = DiffBuilder
            .compare(Input.fromFile(f).build())
            .withTest(Input.fromDocument(d).build())
            .ignoreWhitespace()
            .build();
        assertFalse(diff.toString(), diff.hasDifferences());
    }

    private String[] getComponents(URI u) {
        String s = u.getScheme();
        String p = u.getPath();
        String n, x;
        int i = p.lastIndexOf('/');
        if (i >= 0) {
            n = p.substring(i + 1);
            p = p.substring(0, i + 1);
        } else
            n = null;
        int j = n.lastIndexOf('.');
        if (j >= 0) {
            x = n.substring(j);
            n = n.substring(0, j);
        } else {
            x = null;
        }

        return new String[] { s, p, n, x };
    }

    private boolean hasFileScheme(String[] components) {
        return (components != null) && (components[0] != null) && components[0].equals("file");
    }

    private String joinComponents(String[] components, String extension) {
        assert components != null;
        return joinComponents(components, components[2], extension);
    }

    private String joinComponents(String[] components, String name, String extension) {
        assert components != null;
        assert components[1] != null;
        assert name != null;
        assert extension != null;
        StringBuffer sb = new StringBuffer();
        sb.append(components[1]);
        sb.append('/');
        sb.append(name);
        sb.append(extension);
        return sb.toString();
    }

}
