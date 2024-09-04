@echo off
rem Compile modified GCC
echo Compiling modified GCC...
configure --enable-languages=c
if %errorlevel% neq 0 (
    echo Configuration failed.
    exit /b 1
)

make -j4
if %errorlevel% neq 0 (
    echo Compilation failed.
    exit /b 1
)

rem Compile an example program with the modified GCC
echo Running example...
gcc examples\example.c -o example.exe
if %errorlevel% neq 0 (
    echo Example compilation failed.
    exit /b 1
)

example.exe
if %errorlevel% neq 0 (
    echo Example execution failed.
    exit /b 1
)
