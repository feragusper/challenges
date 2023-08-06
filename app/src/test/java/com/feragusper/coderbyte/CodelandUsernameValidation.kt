package com.feragusper.coderbyte

import org.junit.Test

/**
 * Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine
 * if the string is a valid username according to the following rules:
 *
 * 1. The username is between 4 and 25 characters.
 * 2. It must start with a letter.
 * 3. It can only contain letters, numbers, and the underscore character.
 * 4. It cannot end with an underscore character.
 *
 * If the username is valid then your program should return the string true, otherwise return the string false.
 */
class CodelandUsernameValidation {

    @Test
    fun testChallenge() {
        assert(codelandUsernameValidation("aa_") == "false")

        assert(codelandUsernameValidation("u__hello_world123") == "true")
    }

    private fun codelandUsernameValidation(str: String): String {
        // Check the length of the username
        if (str.length !in 4..25) {
            return "false"
        }

        // Check if the username starts with a letter
        if (!str[0].isLetter()) {
            return "false"
        }

        // Check if the username contains only letters, numbers, and underscores
        if (!str.matches("[a-zA-Z0-9_]+".toRegex())) {
            return "false"
        }

        // Check if the username ends with an underscore character
        if (str.endsWith("_")) {
            return "false"
        }

        // If all checks pass, return true
        return "true"
    }

}