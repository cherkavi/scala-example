"ingest_v[0-9]".r.findFirstIn("/usr/data/ingest_v5/ffdd-dfds-fdfda/").isDefined
"ingest_v[0-9]".r.findFirstIn("/usr/data/INGEST_V5/ffdd-dfds-fdfda/").isDefined
"ingest_v[0-9]".r.findFirstIn("/usr/data/INGEST_V5/ffdd-dfds-fdfda/".toLowerCase).isDefined

"ingest_v[0-9]*".r
  .findFirstIn("/usr/data/ingest_v05/ffdd-dfds-fdfda/")
  .map(v => v.substring("ingest_v".length)).map(Integer.valueOf)

