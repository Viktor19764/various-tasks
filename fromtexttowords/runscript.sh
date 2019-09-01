if [ -f count.txt ]; then
:
else
   java workwithtext/Main input.txt
   a=1
   echo  $a > count.txt
   echo -n >onlyTranslation.txt
fi

IFS=$'\n'       # make newlines the only separator
set -f          # disable globbing
while read in;
     if [ "$in" = "" ]; then
        break;  # skip if no words for google
    fi
     do count=$(cat count.txt);  
    echo "$(cat wordsForGoogle.txt | sed -n $count'p')"  > y.txt; 
    if ! pgrep -x "tor" > /dev/null; then 
          tor & torsocks trans en:uk file://y.txt > x.txt; 
          else    torsocks trans en:uk file://y.txt > x.txt;
    fi; 
    if [ -n "$(cat x.txt | sed -n 1p)" ]; then   
        cat x.txt >> onlyTranslation.txt;     
        echo  $(($count+1)) > count.txt; 
     else     sudo killall tor;
                 sleep $(( ( RANDOM % 40 )  + 40 ))
    fi; 
done < wordsForGoogle.txt

java workwithtext/MainToCsv

rm count.txt

