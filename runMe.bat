@echo off
title Pattern Matching algorithms
javac PatternMatching.java

echo -------------  Input's  ---------------------          ---- BruteForce --    -- BMHarspool --    --- KMP ---- 
java PatternMatching "ABC ABCDAB ABCDABCDABDE" "ABCDABD"


java PatternMatching "FINDINAHAYSTACKNEEDLEIN" "NEEDLE"


java PatternMatching "jim_saw_me_in_a_barbershop" "barber"


java PatternMatching "bard loved bananas" "baobab"


java PatternMatching "bess_knew_about_baobabs" "baobab"


java PatternMatching "ABABABAEABABACBD" "ABABACB"


java PatternMatching "abacaabaccabacabaabb" "abacab"


java PatternMatching "TTATAGATCTCGTATTCTTTTATAGATCTCCTATTCTT" "TCCTATTCTT"


java PatternMatching "ABABABAABACABACABC" "ABACABC"


java PatternMatching "CBBAABAABBCABAAABBBABBAAB" "ABBAAB"

echo ===============================================================================
pause