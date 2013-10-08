################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../TestCCodeGen/Class1.cpp \
../TestCCodeGen/Class2.cpp \
../TestCCodeGen/Class3.cpp 

C_SRCS += \
../TestCCodeGen/Class1.c \
../TestCCodeGen/Class2.c \
../TestCCodeGen/Class3.c 

OBJS += \
./TestCCodeGen/Class1.o \
./TestCCodeGen/Class2.o \
./TestCCodeGen/Class3.o 

C_DEPS += \
./TestCCodeGen/Class1.d \
./TestCCodeGen/Class2.d \
./TestCCodeGen/Class3.d 

CPP_DEPS += \
./TestCCodeGen/Class1.d \
./TestCCodeGen/Class2.d \
./TestCCodeGen/Class3.d 


# Each subdirectory must supply rules for building sources it contributes
TestCCodeGen/%.o: ../TestCCodeGen/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

TestCCodeGen/%.o: ../TestCCodeGen/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


