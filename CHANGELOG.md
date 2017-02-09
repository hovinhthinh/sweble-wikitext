# Change Log
[A guide to writing change logs][keepachangelog]

## Unreleased
### Added
- Added missing setter methods ing ParserConfigImpl

### Changed
- ParserConfigImpl now has proper fields for nonStandardElementBehavior, 
  fosterParenting, and fosterParentingForTransclusions and loads/saves those
  fields from the XML configuration
- Intermediate paragraph tags are no longer subject to foster parenting during
  post-processing

### Fixed
- Fixed bug in pre-processor which resulted in exception when encountering wiki
  markup similar to this: "<ref></ref><</ref>".

## 3.1.3 - 2017-02-06
### Changed
- More fine grained engine integration test helper functions
- Implemented switch langConvTagsEnabled to help with issue #48 Too aggressive
  parsing of `-{ }-` Language Converter tags
- Added switch tagExtensionNamesCaseSensitive to help with issue #43: pre tag
  support is case sensitive
- Automatically expanding `{{!}}` to `|` thus fixing issue #47

### Fixed
- Changed order of processing in LinkTargetParser to fix issue #45 and perform
  link title sanity check with underscores replaced by spaces.
  The title `Template:Did you know nominations/Steve Taylor & The Perfect Foil; Wow to the Deadness'
  contains invalid entities: &_The_Perfect_Foil;
- Fixed InternalError during postprocessing when encountering a <PRE> tag all
  caps by treating it as startTagR14.
- Replaced throw new InternalError by AssertionError to fix bug
  #35 Internal Error
- Ignoring virtual xml tags in WtPrettyPrinter (Caused problems in issue #44)
- Differentiating between italic/bold started by html tag or ticks thus partly
  fixing issue #44

## 3.1.2 - 2017-01-16
### Changed
- Bumped version of tooling parent pom and osr-common dependencies to 3.0.4

## 3.1.1 - 2016-08-12
### Changed
- Made ScopeStack class and methods public (including inner class Scope)

## 3.1.0 - 2016-06-13
### Changed
- Document automatically generated during deserialization in 
  sweble-wom3-json-tools if not doc is explicitly set does not contain article 
  element by default any more.
- Generalized sweble-wom3-json-tools code to work with w3c docs as well (BREAKS INTERFACE)
- Generalized sweble-engine-serialization code to work with w3c docs as well (BREAKS INTERFACE)
- Generalized Wom3Toolbox code to work with w3c docs as well (BREAKS INTERFACE)

### Added
- WomToolbox.{isWomElement, isRtd, isText, isRtdOrText} methods
- WomSerializer.setDocumentImplClassName method

## 3.0.2 - 2016-06-07
### Changed
- Bumped version of tooling parent pom and osr-common dependencies to 3.0.3

## 3.0.1 - 2016-05-03
### Fixed
- Illegal characters had no rtd assigned

### Added
- Added parser configuration options to turn off foster parenting in 
  post-processing

### Changed
- Bumped version of tooling parent pom and osr-common dependencies to 3.0.2

[keepachangelog]: http://keepachangelog.com/