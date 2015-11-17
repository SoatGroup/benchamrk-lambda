tail -$1 $2  | sed -e 's/ \+/;/g' > $2.csv
