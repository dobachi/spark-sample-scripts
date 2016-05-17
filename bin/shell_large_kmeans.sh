EXE_MEM=${EXE_MEM:-1g}
NUM_EXE=${NUM_EXE:-8}

spark-shell --packages com.databricks:spark-csv_2.10:1.4.0 --executor-memory ${EXE_MEM} --num-executors=${NUM_EXE}
