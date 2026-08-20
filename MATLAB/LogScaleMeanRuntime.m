figure

semilogy(insertion.Size,insertion.Mean,'-o')
hold on

semilogy(bubble.Size,bubble.Mean,'-o')

semilogy(merge.Size,merge.Mean,'-o')

semilogy(builtin.Size,builtin.Mean,'-o')

xlabel('Dataset Size')
ylabel('Mean Runtime (ns)')

title('Mean Runtime Comparison (Log Scale)')

legend('Insertion','Bubble','Merge','Built-In')

grid on