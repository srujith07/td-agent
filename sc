curl -XGET "http://localhost:9200/_cat/indices?v&s=index&h=index,store.size&bytes=b&d&time=24h"
GET /_stats
{
  "indices": "your_index_name",
  "docs": true,
  "store": true,
  "indexing": true,
  "query_cache": true,
  "fielddata": true,
  "request_cache": true,
  "flush": true,
  "warmer": true,
  "merges": true,
  "refresh": true,
  "search": true,
  "suggest": true,
  "completion": true,
  "segments": true,
  "translog": true,
  "range": {
    "timestamp": {
      "gte": "now-24h"
    }
  }
}
