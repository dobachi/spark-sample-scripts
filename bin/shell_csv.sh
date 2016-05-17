DATA_DIR=${DATA_DIR:-/tmp}
IRIS="iris.data"
if [ ! -f ${DATA_DIR}/${IRIS} ]; then
  echo "...Download ${IRIS} to ${DATA_DIR}/${IRIS}"
  wget http://archive.ics.uci.edu/ml/machine-learning-databases/iris/${IRIS} -O ${DATA_DIR}/${IRIS}
fi

spark-shell --packages com.databricks:spark-csv_2.10:1.4.0
