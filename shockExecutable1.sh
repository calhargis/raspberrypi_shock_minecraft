#!/usr/bin/env bash

set -euo pipefail

script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
log_file="${SHOCK_LOG_FILE:-$script_dir/shock-executions.log}"
timestamp="$(date '+%Y-%m-%dT%H:%M:%S%z')"

printf '%s channel=1 script=shockExecutable1.sh\n' "$timestamp" >> "$log_file"
