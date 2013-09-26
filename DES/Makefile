CXXFLAGS =	-O2 -g -Wall -fmessage-length=0

OBJS =		DES.o

LIBS =

TARGET =	DES.exe

$(TARGET):	$(OBJS)
	$(CXX) -o $(TARGET) $(OBJS) $(LIBS)

all:	$(TARGET)

clean:
	rm -f $(OBJS) $(TARGET)
