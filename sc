2023-03-15 13:41:34 http_status {app="openfaas"} 1
| regexp "(?P<timestamp>\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})\\s(?P<status>\\w+)\\s{app=.(?P<app_name>\\w+).}\\s(?P<result>\\d+)"

/^(?P<timestamp>\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2})\s(?P<status>\w+)\s{app="(?P<app_name>\w+)"}\s(?P<result>\d+)/gm
