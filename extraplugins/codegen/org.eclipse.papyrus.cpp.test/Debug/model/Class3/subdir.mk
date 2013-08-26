################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../model/Class3/Operation1.cpp 

OBJS += \
./model/Class3/Operation1.o 

CPP_DEPS += \
./model/Class3/Operation1.d 


# Each subdirectory must supply rules for building sources it contributes
model/Class3/%.o: ../model/Class3/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


