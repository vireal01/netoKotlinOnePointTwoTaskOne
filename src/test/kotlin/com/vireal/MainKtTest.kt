package com.vireal

import org.junit.Test
import org.junit.Assert.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class MainKtTest {

    @Test
    fun mainTest(){
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        main()
        val expected = "сумма транзакции 4000 руб. 0 коп.\n"
        assertEquals(expected, outContent.toString())
    }



}