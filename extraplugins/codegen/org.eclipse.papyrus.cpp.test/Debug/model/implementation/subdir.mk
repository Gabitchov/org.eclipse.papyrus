################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../model/implementation/Class0.cpp \
../model/implementation/Class1.cpp 

OBJS += \
./model/implementation/Class0.o \
./model/implementation/Class1.o 

CPP_DEPS += \
./model/implementation/Class0.d \
./model/implementation/Class1.d 


# Each subdirectory must supply rules for building sources it contributes
model/implementation/%.o: ../model/implementation/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


