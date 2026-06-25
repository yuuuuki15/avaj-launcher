JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin
INPUT_FILE = scenario.txt

MAIN_CLASS = com.ykawakit.Simulator

SRCS = $(shell find $(SRC_DIR) -name "*.java")
CLASSES = $(SRCS:$(SRC_DIR)/%.java=$(BIN_DIR)/%.class)

all: $(BIN_DIR) $(CLASSES)

$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) -d $(BIN_DIR) -cp $(SRC_DIR) $<

$(BIN_DIR):
	mkdir -p $(BIN_DIR)

run: all
	$(JAVA) -cp $(BIN_DIR) $(MAIN_CLASS) $(INPUT_FILE)

clean:
	rm -rf $(BIN_DIR)

.PHONY: all run clean