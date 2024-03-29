2023-03-15 13:41:34 http_status {app="openfaas"} 1

/^(?P<timestamp>\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2})\s(?P<status>\w+)\s{app="(?P<app_name>\w+)"}\s(?P<result>\d+)/gm

{namespace="sla03"} | regexp "(?P<timestamp>\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})\\s(?P<status>\\w+)\\s{app=.(?P<app_name>\\w+).}\\s(?P<result>\\d+)"

{namespace="sla03"}  
| regexp "(?P<timestamp>\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})\\s*(?P<status>\\w+)\\s*{app=.(?P<app_name>\\w+).}\\s*(?P<result>\\d+)"

{namespace="sla03"} | regexp "(?P<status>\\w+)\\s*{app=.(?P<app_name>\\w+).}\\s*(?P<result>\\d+)" | result >= 1

Note: don't use timestamp in regex

count_over_time({namespace="sla03"} | regexp "(?P<status>\\w+)\\s*{app=.(?P<app_name>\\w+).}\\s*(?P<result>\\d+)" | result = 0 [1m] )

sum(count_over_time({namespace="sla03"} | regexp "(?P<status>\\w+)\\s*{app=.(?P<app_name>\\w+).}\\s*(?P<result>\\d+)" | result = 1 [1m] )) by (app_name)

sum(count_over_time({namespace="sla03"} | regexp "(?P<status>\\w+)\\s*{app=.(?P<app_name>\\w+).}\\s*(?P<result>\\d+)" | app_name ="gitlab" | result = 1 [1m] )) by (app_name)
