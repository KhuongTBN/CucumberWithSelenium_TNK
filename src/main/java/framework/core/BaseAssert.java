package framework.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

public class BaseAssert extends SoftAssert {
	Logger logger = Logger.getLogger(this.getClass());

	public void assertContain(String actual, String expected, String message) {
		String msg = String.format(message + ". Expect the text '[%s]' contains '[%s]'. <br>", actual, expected);
		assertTrue(actual.contains(expected),msg);
	}
	
	public void assertEqualsIgnoreCase(String actual, String expected, String message) {
		String msg = String.format(message + ". Expect the text '[%s]' is equalsIgnoreCase '[%s]'. <br>", actual, expected);
		assertTrue(actual.equalsIgnoreCase(expected),msg);
	}

	public void assertNotContain(String actual, String expected, String message) {
		String msg = String.format(message + ". Expect the text '[%s]' does not contain '[%s]'. <br>", actual, expected);
		assertTrue(!actual.contains(expected),msg);
	}

	public void assertEmpty(String actual, String message) {
		String msg = String.format(message + ". Expect the text is empty, but it is '[%s]'. <br>", actual);
		assertTrue(actual.isEmpty(), msg);
	}

	public void assertLagerOrEqual(Integer actual, Integer expected, String message) {
		String msg = String.format(message + ". Expect [%s] >= [%s]. <br>", actual, expected);
		assertTrue(actual >= expected, msg);
	}

	public void assertLagerOrEqual(Long actual, Long expected, String message) {
		String msg = String.format(message + ". Expect [%s] >= [%s]. <br>", actual, expected);
		assertTrue(actual >= expected, msg);
	}

	public void assertLager(Integer actual, Integer expected, String message) {
		String msg = String.format(message + ". Expect [%s] > [%s]. <br>", actual, expected);
		assertTrue(actual > expected, msg);
	}

	public void assertLager(Long actual, Long expected, String message) {
		String msg = String.format(message + ". Expect [%s] > [%s]. <br>", actual, expected);
		assertTrue(actual > expected, msg);
	}

	public void assertNotNullEmpty(Integer actual, String message) {
		String msg = String.format(message + ". Expect [%s] is not null or empty. <br>", actual);
		assertNotNull(actual, msg);
		assertNotEquals(actual, "", msg);
	}

	public void assertNotNullEmpty(String actual, String message) {
		String msg = String.format(message + ". Expect [%s] is not null or empty. <br>", actual);
		assertNotNull(actual, msg);
		assertNotEquals(actual.trim(), "", msg);
	}

	public void assertNotNullEmptyZero(Integer actual, String message) {
		String msg = String.format(message + ". Expect [%s] is not null or empty or zero. <br>", actual);
		assertNotNull(actual, msg);
		assertNotEquals(actual, "", msg);
		assertNotEquals(actual, Integer.valueOf(0), msg);
	}

	public void assertNotNullEmptyZero(Long actual, String message) {
		String msg = String.format(message + ". Expect [%s] is not null or empty or zero. <br>", actual);
		assertNotNull(actual, msg);
		assertNotEquals(actual, "", msg);
		assertNotEquals(actual, Long.valueOf(0), msg);
	}

	public void assertLessThan(Integer actual, Integer expected, String message) {
		String msg = String.format(message + ". Expect [%s] < [%s]. <br>", actual, expected);
		assertTrue(actual < expected, msg);
	}

	public void assertLessThan(Long actual, Long expected, String message) {
		String msg = String.format(message + ". Expect [%s] < [%s]. <br>", actual, expected);
		assertTrue(actual < expected, msg);
	}

	public void assertLessOrEqual(Integer actual, Integer expected, String message) {
		String msg = String.format(message + ". Expect [%s] <= [%s]. <br>", actual, expected);
		assertTrue(actual <= expected, msg);
	}

	public void assertLessOrEqual(Long actual, Long expected, String message) {
		String msg = String.format(message + ". Expect [%s] <= [%s]. <br>", actual, expected);
		assertTrue(actual <= expected, msg);
	}

	public void assertSameDay(Long actual, Long expected, String message) {
		String msg = String.format(message + ". Expect the '[%s]' is same the day of '[%s]'. <br>", actual, expected);
		Date date1 = new Date(actual);
		Date date2 = new Date(expected);
		assertTrue(DateUtils.isSameDay(date1, date2), msg);
	}

	public void assertLargerCurrentTime(Long actual, String message) {
		long cur = BaseTimestamp.nowTimeStamp();
		String msg = String.format(message + ". Expect the time '[%s]' is greater than the current time '[%s]'. <br>", actual, cur);
		assertTrue(actual > cur, msg);
	}

	public void assertUrlalive(String url, String message) {
		String msg = String.format(message + ". Expect the url '[%s]' is alive'. <br>", url);
		try {
			URL myUrl = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) myUrl.openConnection();
			assertEquals(huc.getResponseCode(), 200, msg);
		} catch (IOException e) {
			logger.error("The url" + url + " is error: " + e.getMessage());
		}
	}
		
	public void assertContains(List<String> lstString, String expectedStringItem, String message) {
		String msg = String.format(message + ". Expect [[%s]] contains [%s]. <br>", lstString.toString(), expectedStringItem);
		assertTrue(lstString.contains(expectedStringItem), msg);
	}
}
