# SDE

## Enhancement: Byte Size and Time Duration Units Parsers

This submission includes the implementation for the Wrangler enhancement assignment. Due to GitHub file size limitations, the full modified project is included as a ZIP file.

### 📦 How to Access

Please download and unzip the file `ass.zip` located in the root of this repository.

### 📘 What's Included

- Grammar updates (`Directives.g4`)
- New classes: `ByteSize.java`, `TimeDuration.java`
- New directive: `AggregateStats`
- Unit tests for the new token types and the directive
- `prompts.txt` listing AI tools usage prompts
- Evidence of build and test execution

### 🚀 Usage Example

You can use the new directive in your recipe like:

```wrangler
aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec


