GET index_name/_search
{
  "query": {
    "bool": {
      "must":[ 
              {
                "range": {
                  "date_field_name": {
                    "gte": "2019-09-23 18:30:00",
                    "lte": "2019-09-24 18:30:00"
                  }
                }
              }
      ]
    }
  },
  "size": 10
}
