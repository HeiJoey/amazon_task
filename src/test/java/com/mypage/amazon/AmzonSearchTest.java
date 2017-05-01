/**
 * Created by Jacob_MACMini on 01/05/2017.
 */

package com.mypage.amazon;
import org.junit.Test;

public class AmzonSearchTest /*extends Locomotive*/{

    @Test
    public void testTextExist()
    {
        AmzonSearch.main("http://amazon.com");
    }

}
