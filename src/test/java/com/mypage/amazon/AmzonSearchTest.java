/**
 * Created by Jacob_MACMini on 01/05/2017.
 */

package com.mypage.amazon;
import org.junit.Test;

public class AmzonSearchTest{

    @Test
    public void testTextExist()
    {
        String myLink = "http://amazon.com";
        AmzonSearch.main(myLink);
    }
}
